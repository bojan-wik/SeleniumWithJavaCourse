package Chapter31_CoreJava2;

import Chapter30_CoreJava1.FunctionOverriding;

/**
 * Package in Java – to sposób na enkapsulację zestawu klas, interfejsów, subpackages.
 *      a) Keyword 'import' np. import package.className
 *      b) Niektórych package nie trzeba specjalnie importować - są one ustawione jako defaultowe/globalne I uruchamiane razem z compilerem np. Java.lang
 *      c) Inne trzeba specjalnie importować, żeby móc z nich korzystać np. Java.util
 *
 * Package types:
 * 1) In-built
 * 2) User-defined
 */

public class i_Packages {

    public static void main(String[] args) {
        /**
         * Klasa 'A' może korzystać z klasy 'B' bezpośrednio przez stworzenie obiektu, tylko i wyłącznie wtedy, gdy obie klasy należą do tego samego package.
         * Niech:
         *      Class 'A' = bieżąca klasa 'i_Packages',
         *      Class 'B' = 'e_ThisKeyword'
         * Obie klasy należą do tego samego package = 'Chapter31_CoreJava2'
         */
        e_ThisKeyword classB = new e_ThisKeyword();
        classB.sampleMethod();
        /**
         * Teraz w Klasie 'A' chcę skorzystać z klasy, która jest w innym package.
         * Niech:
         *      Class 'A' = bieżąca klasa 'i_Packages',
         *      Class 'B1' = 'FunctionOverrriding' z package 'Chapter30'
         * Poza stworzeniem obiektu klasy muszę jeszcze specjalnie zaimportować ten package i tą klasę ('import Chapter30.FunctionOverriding')
         */
        FunctionOverriding classB1 = new FunctionOverriding();
        classB1.Roof();
    }
}
