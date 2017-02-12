package com.capgemini.hanoiTest;

import org.junit.Test;

import com.capgemini.hanoi.Gra;

public class HanoiTest {
	
@Test(expected=IllegalStateException.class)
public void PrzeniesKrazekZPustejWierzy() throws Exception{
	Gra NowaGra = new Gra(5);
	NowaGra.SprawdzRuch(2,0);
}
@Test(expected=IllegalStateException.class)
public void PrzeniesKrazekWiekszyNaMniejszy() throws Exception{
	Gra NowaGra = new Gra(5);
	NowaGra.SprawdzRuch(0,1);
	NowaGra.SprawdzRuch(0,1);
}
@Test(expected=IllegalStateException.class)
public void PrzeniesKrazekNaNieIstniejacaWieze() throws Exception{
	Gra NowaGra = new Gra(5);
	NowaGra.SprawdzRuch(0,8);
}
@Test(expected=IllegalStateException.class)
public void UtworzUjemnaIloscKrazkow() throws Exception{
	Gra NowaGra = new Gra(-5);
}
}
