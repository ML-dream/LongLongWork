package JSOM;

import java.io.Serializable;
//Factory ��ʲô��������
public class Factory implements Serializable {
	private String UID;
	private String Name;
	private int _id;
	private int _uid;
	private int _pid;
	private int _level;
	private int _height;
	
	
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int get_uid() {
		return _uid;
	}
	public void set_uid(int _uid) {
		this._uid = _uid;
	}
	public int get_pid() {
		return _pid;
	}
	public void set_pid(int _pid) {
		this._pid = _pid;
	}
	public int get_level() {
		return _level;
	}
	public void set_level(int _level) {
		this._level = _level;
	}
	public int get_height() {
		return _height;
	}
	public void set_height(int _height) {
		this._height = _height;
	}
	

}
