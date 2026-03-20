package com.Valeria.computadora

fun main(){
    MenuC()
}

fun MenuC(){
    val calc = Calculadora("Casio", 7, 32.99 )

    var opcion: Int
    var a: Double
    var b: Double
    do{
        println("Que desea hacer:\n" +
                "1) Sumar\n" +
                "2) Restar\n" +
                "3) Multiplicar\n" +
                "4) Dividir\n" +
                "5) Ver marca, años de vida y precio\n" +
                "6) Salir")
        opcion= readln().toInt()

        when(opcion){

            1 -> {
                println("Ingrese dos datos:\na:")
                a=readln().toDouble()
                println("\nb:")
                b=readln().toDouble()
                    println(calc.Sumar(a, b))}
            2 -> {
                println("Ingrese dos datos:\na:")
                a=readln().toDouble()
                println("\nb:")
                b=readln().toDouble()
                println(calc.Restar(a,b))}
            3 -> {
                println("Ingrese dos datos:\na:")
                a=readln().toDouble()
                println("\nb:")
                b=readln().toDouble()
                println(calc.Multiplicar(a,b))
            }
            4 -> {
                println("Ingrese dos datos:\na:")
                a=readln().toDouble()
                println("\nb:")
                b=readln().toDouble()
                println(calc.Dividir(a,b))
            }
            5 -> calc.Datos()
            else -> println("Opcion no valida")
        }
    }while(opcion!=6)

}

class Calculadora(val marca: String, val anios_vida: Int, var precio: Double){

    fun Datos(){
        println("Marca: $marca\nAños de vida: $anios_vida\nPrecio: $precio")
    }
    fun Sumar( a: Double, b: Double): Double {
        val suma: Double = a + b
        return suma
    }

    fun Restar( a: Double, b: Double): Double{
        val resta: Double = a - b
        return resta
    }

    fun Multiplicar( a: Double, b: Double): Any {
        if(b.toInt() == 0){
            return println("No se puede dividir por 0")
        }
        val multiplicar: Double = a * b
        return multiplicar
    }

    fun Dividir( a: Double, b: Double): Double{
        val dividir: Double = a / b
        return dividir
    }
}