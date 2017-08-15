package metal.gear.model.btScraptModel.mapper;

import java.util.List;

import metal.gear.model.btScraptModel.vo.Torrent;

public interface TorrentMapper {
	  public void add(Torrent torrent);  
      
	    public void delete(int id);  
	        
	    public Torrent get(int id);  
	      
	    public void update(Torrent torrent);   
	        
	    public List<Torrent> list();
	     
	    public int count();  
}
