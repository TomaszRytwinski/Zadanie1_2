package com.capgemini.hanoi;
import java.util.Scanner;

public class Game {
	private Tower [] tower=new Tower[3];
	private int amountOfDisc;
	Scanner scanner = new Scanner(System.in);
	public Game(){
		String Bufor;
		amountOfDisc=-1;
		do{
			try{
				System.out.println("Podaj ilosc krazkow");
				Bufor=scanner.nextLine();
				amountOfDisc=Integer.parseInt(Bufor);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Prosze wpisz liczbe");
			}
		}while(amountOfDisc<0);
		setTower();
	}
	public Game(int _amountOfDisc) throws IllegalStateException{
		if(_amountOfDisc<=0){
			throw new IllegalStateException();
		}
		amountOfDisc = _amountOfDisc;
		setTower();
	}
	private void drawTower(){
		System.out.println("Kolejny ruch");
		System.out.println("Wieza nr 0");
		tower[0].towerState();
		System.out.println("Wieza nr 1");
		tower[1].towerState();
		System.out.println("Wieza nr 2");
		tower[2].towerState();
		System.out.println("");System.out.println("");
	}
	private void setTower(){
		Disc[] listOfDisc;
		listOfDisc = new Disc[amountOfDisc];
		for (int i=0;i<3;i++){
			tower[i] = new Tower();
		}
		for (int i=0; i<amountOfDisc;i++){
			listOfDisc[i]= new Disc(amountOfDisc-i);
			tower[0].addDisc(listOfDisc[i]);
		}
	}
	private int enterAmovement(){
		String Bufor;
		int choise=-1;
		do{
			try{
				Bufor=scanner.nextLine();
				choise=Integer.parseInt(Bufor);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Prosze wpisz liczbe");
			}
		}while(choise>2 || choise<0);
		return choise;
	}
	public void checkMovement(int from,int to) throws IllegalStateException{
		if(from<0 || from>2 || to<0 || to>2){
			throw new IllegalStateException();
		}
		if (tower[from].getAmountOfDisc()<=0){
			System.out.println("Pusta wieza");
			throw new IllegalStateException();
		}else if(tower[to].getAmountOfDisc()>0 && 
				tower[from].getFirstDisc().getSize()>=tower[to].getFirstDisc().getSize()){
			System.out.println("Nie wolno klasc wiekszego na mniejszy");
			throw new IllegalStateException();
		}else {
			tower[to].addDisc(tower[from].deleteDisc());	
		}
	}
	private int whereSmallestDisc(){
		int whereSmallestDisc=0;
		for (int i=0;i<3;i++){
			if (tower[i].getFirstDisc().getSize()==1){
				whereSmallestDisc=i;
			}
		}
		return whereSmallestDisc;
	}
	public static void main(String[] args) {
		int choice=0;
		int movements=0;
		int from;
		int to;
		boolean win=false;
		Game newGame = new Game();
		newGame.drawTower();
		do
		{
			try{
				System.out.println("Kolejny ruch. Z?");
				from=newGame.enterAmovement();
				System.out.println("Do?");
				to=newGame.enterAmovement();
				newGame.checkMovement(from,to);
			}catch(IllegalStateException e){
				System.out.println("Nie prawidlowy ruch");
			}
			newGame.drawTower();
			if ((newGame.tower[0].getAmountOfDisc()==0 && newGame.tower[1].getAmountOfDisc()==0) || (newGame.tower[0].getAmountOfDisc()==0 && newGame.tower[2].getAmountOfDisc()==0)){
				win=true;
			}
			movements++;
		}while(choice!=4 && win==false);
		newGame.scanner.close();
		if (win==true ){
			System.out.println("Wygrana!!! W " + movements + "krokow");
		}
	}
}