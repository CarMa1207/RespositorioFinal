package com.example.trabajofinal.Estructuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolAVLTest {



        @Test
        void isEquilibradoRecursivo() {
            Nodo<Integer> nodo1 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(1);
            ArbolAVL arbol= new ArbolAVL(2);
            arbol.getRaiz().setNododcha(nodo1);
            arbol.getRaiz().setNodoizq(nodo2);
            assertTrue(arbol.isEquilibradoRecursivo(arbol));
            arbol.add(3);
            arbol.add(4);
            arbol.add(5);
            arbol.add(7);
            assertFalse(arbol.isEquilibradoRecursivo(arbol));


        }

        @Test
        void rotacionII() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(2);
            Nodo<Integer> nodo11 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            arbol.getRaiz().setNododcha(nodo1);
            arbol.getRaiz().setNodoizq(nodo11);
            arbol.getRaiz().getNodoizq().setNodoizq(nodo2);
            arbol.getRaiz().getNodoizq().getNodoizq().setNodoizq(nodo3);
            assertEquals(10, arbol.getRaiz().getdato());
            assertEquals(9,arbol.getRaiz().getNodoizq().getdato());
            assertEquals(8,arbol.getRaiz().getNodoizq().getNodoizq().getdato());
            assertEquals(7,arbol.getRaiz().getNodoizq().getNodoizq().getNodoizq().getdato());

            arbol.RotacionII(nodo11);
            assertTrue(arbol.isEquilibradoRecursivo(arbol));


        }

        @Test
        void rotacionDD() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(2);
            Nodo<Integer> nodo11 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            arbol.getRaiz().setNodoizq(nodo1);
            arbol.getRaiz().setNododcha(nodo11);
            arbol.getRaiz().getNododcha().setNododcha(nodo2);
            arbol.getRaiz().getNododcha().getNododcha().setNododcha(nodo3);


            arbol.RotacionDD(nodo11);
            assertTrue(arbol.isEquilibradoRecursivo(arbol));
        }

        @Test
        void rotacionDI() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(2);
            Nodo<Integer> nodo11 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            Nodo<Integer> nodo4 = new Nodo<>(6);
            Nodo<Integer> nodo5 = new Nodo<>(11);

            arbol.getRaiz().setNododcha(nodo11);
            arbol.getRaiz().setNodoizq(nodo1);

            arbol.getRaiz().getNododcha().setNododcha(nodo4);
            arbol.getRaiz().getNododcha().getNododcha().setNodoizq(nodo2);
            assertFalse(arbol.isEquilibradoRecursivo(arbol));
            arbol.RotacionDI(nodo11);




        }

        @Test
        void rotacionID() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(2);
            Nodo<Integer> nodo11 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            Nodo<Integer> nodo4 = new Nodo<>(6);
            Nodo<Integer> nodo5 = new Nodo<>(11);
            arbol.getRaiz().setNodoizq(nodo1);
            arbol.getRaiz().setNododcha(nodo3);
            arbol.getRaiz().getNodoizq().setNodoizq(nodo2);
            arbol.getRaiz().getNodoizq().getNodoizq().setNododcha(nodo11);
            assertFalse(arbol.isEquilibradoRecursivo(arbol));
            arbol.RotacionID(nodo1);
            assertTrue(arbol.isEquilibradoRecursivo(arbol));
        }

        @Test
        void detectarDesequilibrio() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            Nodo<Integer> nodo4 = new Nodo<>(6);
            Nodo<Integer> nodo5= new Nodo<>(11);
            arbol.add(nodo1);
            arbol.getRaiz().setNododcha(nodo5);
            arbol.add(nodo2);
            arbol.add(nodo3);

            assertEquals("II", arbol.detectarDesequilibrio(arbol));
        }

        @Test
        void equilibrar() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            Nodo<Integer> nodo4 = new Nodo<>(6);
            Nodo<Integer> nodo5= new Nodo<>(11);
            arbol.add(nodo1);
            arbol.getRaiz().setNododcha(nodo5);
            arbol.add(nodo2);
            arbol.add(nodo3);
            assertFalse(arbol.isEquilibradoRecursivo(arbol));
            arbol.equilibrar(arbol);
            assertTrue(arbol.isEquilibradoRecursivo(arbol));

        }

        @Test
        void insercion() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(2);
            Nodo<Integer> nodo11 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            Nodo<Integer> nodo4 = new Nodo<>(6);
            Nodo<Integer> nodo5 = new Nodo<>(11);
            arbol.getRaiz().setNodoizq(nodo1);
            arbol.getRaiz().setNododcha(nodo3);
            arbol.getRaiz().getNodoizq().setNodoizq(nodo2);
            arbol.insercion(arbol,nodo4);
            assertTrue(arbol.isEquilibradoRecursivo(arbol));
        }

        @Test
        void eliminar() {
            ArbolAVL arbol= new ArbolAVL(10);
            Nodo<Integer> nodo1 = new Nodo<>(2);
            Nodo<Integer> nodo11 = new Nodo<>(9);
            Nodo<Integer> nodo2 = new Nodo<>(8);
            Nodo<Integer> nodo3 = new Nodo<>(7);
            Nodo<Integer> nodo4 = new Nodo<>(6);
            Nodo<Integer> nodo5 = new Nodo<>(11);
            arbol.getRaiz().setNodoizq(nodo1);
            arbol.getRaiz().setNododcha(nodo3);
            arbol.getRaiz().getNodoizq().setNodoizq(nodo2);
            arbol.getRaiz().getNodoizq().getNodoizq().setNodoizq(nodo5);
            assertFalse(arbol.isEquilibradoRecursivo(arbol));
            arbol.eliminar(arbol,nodo5);
            assertTrue(arbol.isEquilibradoRecursivo(arbol));
        }
    }
