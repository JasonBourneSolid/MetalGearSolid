package metal.gear.model.loginModel.security;

import metal.gear.property.SystemProperty;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;



public class MyRealm extends AuthorizingRealm{
    private static Logger Log = Logger.getLogger(MyRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) 
	{
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException 
	{
		UsernamePasswordToken loginToken = (UsernamePasswordToken)token;
		//获取系统配置的用户
		String username =  SystemProperty.getProper("user");
		String password  = SystemProperty.getProper("pass");
		if(username.equals(loginToken.getUsername())){
				System.out.println(loginToken.getPassword().toString());
				return  new SimpleAuthenticationInfo();
		}
		return null;
	}


}
