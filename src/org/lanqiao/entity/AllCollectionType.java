package org.lanqiao.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class AllCollectionType {
	private List<String> list;
	private String[] arr;
	private Map<String,String> map;
	private Set<String> set;
	private Properties props;
	public AllCollectionType() {
		
	}
	public AllCollectionType(List<String> list) {
		this.list = list;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String[] getArr() {
		return arr;
	}
	public void setArr(String[] arr) {
		this.arr = arr;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	@Override
	public String toString() {
		String strContext = "";
		for(String str:arr) {
			strContext += str + ",";
		}
		return "list: " + this.list + "\nset: " + this.set + "\nmap: " + this.map + "\nprops: " + this.props + "\nArray: " + strContext;
	}
}
