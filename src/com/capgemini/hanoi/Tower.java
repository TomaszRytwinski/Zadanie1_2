package com.capgemini.hanoi;
import java.util.ArrayList;
import java.util.List;

public class Tower {
	private List<Disc> list = new ArrayList<Disc>();
	private int amountOfDiscs;
	public Tower(){
		amountOfDiscs=0;
	}
	public void addDisc(Disc _disc){
		list.add(0, _disc);
	}
	public Disc deleteDisc(){
		Disc temp = list.get(0);
		list.remove(0);
		return temp;
	}
	public void towerState(){
		for(int i=0;i<list.size();i++){
			System.out.println(i + " " + list.get(i).getSize());
		}
	}
	public int getAmountOfDisc(){
		amountOfDiscs=list.size();
		return amountOfDiscs;
	}
	public int getSizeofDisc(int index){
		return list.get(index).getSize();
	}
	public Disc getFirstDisc(){
		return list.get(0);
	}
}
