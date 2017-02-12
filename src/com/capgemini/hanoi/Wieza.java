package com.capgemini.hanoi;
import java.util.ArrayList;
import java.util.List;

public class Wieza {
	private List<Krazek> stos = new ArrayList<Krazek>();
	private int IloscKrazkow;
	public Wieza(){
		IloscKrazkow=0;
	}
	public void DodajKrazek(Krazek _krazek){
		stos.add(0, _krazek);
	}
	public Krazek UsunKrazek(){
		Krazek temp = stos.get(0);
		stos.remove(0);
		return temp;
	}
	public void StanWiezy(){
		for(int i=0;i<stos.size();i++){
			System.out.println(i + " " + stos.get(i).GetSrednica());
		}
	}
	public int GetIloscKrazkow(){
		IloscKrazkow=stos.size();
		return IloscKrazkow;
	}
	public int GetSrednicaKrazka(int index){
		return stos.get(index).GetSrednica();
	}
	public Krazek GetPierwszyKrazek(){
		return stos.get(0);
	}
}
