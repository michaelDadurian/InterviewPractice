/*Design a juke box
	-CD player
	-CD
	-Display() displays length of song, remaining time and playlist
	
	-playlist creation (add, delete, shuffle)
	-CD selector
	-Track selector
	-queue up a song
	-get next song from playlist
	
	User:
	-add
	-delete
	-credit info
*/

public class CD{}
public class CDPlayer{
	private Playlist playlist;
	private CD cd;
	
	public Playlist getPlayList(){
		return playlist;
	}
	
	public void setPlayList(Playlist playlist){
		this.playlist = playlist;
	}
	
	public CD getCD(){
		return cd;
	}
	
	public void setCD(CD cd){
		this.cd = cd;
	}
	
	//create cdplayer with playlist
	public CDPlayer(Playlist playlist){
		this.playlist = playlist;
	}
	
	//create cdplayer with cd and playlist
	public CDPlayer(CD cd, Playlist playlist){
		this.cd = cd;
		this.playlist = playlist;
	}
	
	public CDPlayer (CD cd){
		this.cd = cd;
	}
	
	public void playTrack(Song s){}
}

public class JukeBox{
	private CDPlayer cdPlayer;
	private Set<CD> cdCollection;
	private User user;
	private TrackSelector ts;
	
	public JukeBox(CDPlayer cdPlayer, Set<CD> cdCollection, User user, TrackSelector ts){
		this.cdPlayer = cdPlayer;
		this.cdCollection = cdCollection;
		this.user = user;
		this.ts = ts;
	}
	
	public Song getCurrentTrack(){
		return ts.getCurrentSong();
	}
}

public class Playlist{
	private Song currTrack;
	private Queue<Song> queue;
	public Playlist(Song currTrack, Queue<Song> queue){
		this.currTrack = currTrack;
		queue = new Queue<Song>;
	}
	
	public Song getNextTrack(){
		return queue.peek();
	}
	
	public void queueUpTrack(Song s){
		queue.add(s);
	}
}

public class TrackSelector{
	private Song currentSong;
	public TrackSelector(Song s){
		currentSong = s;
	}
	public void setTrack(Song s){
		currentSong = s;
	}
	
	public Song getCurrentSong(){
		return currentSong;
	}
}

public class User{
	private String name;
	private long ID;
	
	public User(String name, long ID){
		this.name = name;
		this.ID = ID;
	}
	
	public User getUser(){
		return this;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public long getID(){
		return ID;
	}
	
	public void setID(long ID){
		this.ID = ID;
	}
}

public class Song{
	private String songName;
	public Song(String songName){
		this.songName = songName;                            
	}
}

