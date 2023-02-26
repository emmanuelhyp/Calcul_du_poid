package com.example.calculdupoid.model;

import junit.framework.TestCase;

public class ProfilTest extends TestCase {
    private Profil profil = new Profil(35,67,165,0);
    private float Img = (float) 32.5;
    private String message = "Grosses";


    public void testGetImg() {
        assertEquals(Img, profil.getImg(),(float) 0.1);
    }

    public void testGetMessage() {
        assertEquals(message, profil.getMessage());
    }
}