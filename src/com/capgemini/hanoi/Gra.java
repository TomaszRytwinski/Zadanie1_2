package com.capgemini.hanoi;
import java.util.Scanner;

public class Gra {
	private Wieza [] Wieze=new Wieza[3];
	private int IloscKrazkow;
	Scanner scanner = new Scanner(System.in);
	public Gra(){
		String Bufor;
		IloscKrazkow=-1;
		do{
			try{
				System.out.println("Podaj ilosc krazkow");
				Bufor=scanner.nextLine();
				IloscKrazkow=Integer.parseInt(Bufor);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Prosze wpisz liczbe");
			}
		}while(IloscKrazkow<0);
		UstawWieze();
	}
	public Gra(int _IloscKrazkow) throws IllegalStateException{
		if(_IloscKrazkow<=0){
			throw new IllegalStateException();
		}
		IloscKrazkow = _IloscKrazkow;
		UstawWieze();
	}
	private void RysujWieze(){
		System.out.println("Kolejny ruch");
		System.out.println("Wieza nr 0");
		Wieze[0].StanWiezy();
		System.out.println("Wieza nr 1");
		Wieze[1].StanWiezy();
		System.out.println("Wieza nr 2");
		Wieze[2].StanWiezy();
		System.out.println("");System.out.println("");
	}
	private void UstawWieze(){
		Krazek[] ListaKrazkow;
		ListaKrazkow = new Krazek[IloscKrazkow];
		for (int i=0;i<3;i++){
			Wieze[i] = new Wieza();
		}
		for (int i=0; i<IloscKrazkow;i++){
			ListaKrazkow[i]= new Krazek(IloscKrazkow-i);
			Wieze[0].DodajKrazek(ListaKrazkow[i]);
		}
	}
	private int WczytajRuch(){
		String Bufor;
		int Wybor=-1;
		do{
			try{
				
				Bufor=scanner.nextLine();
				Wybor=Integer.parseInt(Bufor);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Prosze wpisz liczbe");
			}
		}while(Wybor>2 || Wybor<0);
		return Wybor;
	}
	public void SprawdzRuch(int KrokZ,int KrokDo) throws IllegalStateException{
		if(KrokZ<0 || KrokZ>2 || KrokDo<0 || KrokDo>2){
			throw new IllegalStateException();
		}
		if (Wieze[KrokZ].GetIloscKrazkow()<=0){
			System.out.println("Pusta wieza");
			throw new IllegalStateException();
		}else if(Wieze[KrokDo].GetIloscKrazkow()>0 && Wieze[KrokZ].GetPierwszyKrazek().GetSrednica()>=Wieze[KrokDo].GetPierwszyKrazek().GetSrednica()){
			System.out.println("Nie wolno klasc wiekszego na mniejszy");
			throw new IllegalStateException();
		}else {
			Wieze[KrokDo].DodajKrazek(Wieze[KrokZ].UsunKrazek());	
		}
	}
	public static void main(String[] args) {
		int wybor=0;
		int iloscRuchow=0;
		int KrokZ;
		int KrokDo;
		boolean wygrana=false;
		Gra NowaGra = new Gra();
		NowaGra.RysujWieze();
		do
		{
			try{
				System.out.println("Kolejny ruch. Z?");
				KrokZ=NowaGra.WczytajRuch();
				System.out.println("Do?");
				KrokDo=NowaGra.WczytajRuch();
				NowaGra.SprawdzRuch(KrokZ,KrokDo);
			}catch(IllegalStateException e){
				System.out.println("Nie prawidlowy ruch");
			}
			NowaGra.RysujWieze();
			if ((NowaGra.Wieze[0].GetIloscKrazkow()==0 && NowaGra.Wieze[1].GetIloscKrazkow()==0) || (NowaGra.Wieze[0].GetIloscKrazkow()==0 && NowaGra.Wieze[2].GetIloscKrazkow()==0)){
				wygrana=true;
			}
			iloscRuchow++;
		}while(wybor!=4 && wygrana==false);
		NowaGra.scanner.close();
		if (wygrana==true ){
			System.out.println("Wygrana!!! W " + iloscRuchow + "krokow");
		}
	}
}