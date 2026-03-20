package com.Valeria.computadora

val ProgramasInstalados = listOf("WhatsApp 2009", "Sky 2026","YouTube 2026")
fun Menu(){
    val Computadora = Computadora(16 , 256, "Windows",)
    Computadora.Encender()
    var opcion: Int
    do{
    println("Que desea hacer:\n" +
            "1) Apagar\n" +
            "2) Actualizar\n" +
            "3) Ver las aplicaciones instaladas de este año\n" +
            "4) Ver los valores actuales")
    opcion= readln().toInt()

    when(opcion){
        1 -> Computadora.Apagar()
        2 -> Computadora.Actualizar()
        3 -> Computadora.ProgramasInstalados()
        4 -> println("\nActualmente posee una memoria de: ${Computadora.Memoria}, " +
                "RAM de ${Computadora.RAM} y sistema operativo ${Computadora.SO} ")
        else -> println("Opcion no valida")
    }
        }while(opcion!=1)

}

fun main(){
    Menu()
}

class Computadora(var RAM: Int, var Memoria: Int, var SO: String) {
    fun Encender() {
        println("Computadora encendia")
    }

    fun Apagar() {
        println("Computadora apagada")
    }

    fun Actualizar() {
        println("Actualizar RAM a: ")
        RAM = readln().toInt()

        println("Actualizar Memoria a: ")
        Memoria = readln().toInt()

        println("Actualizar Sistema operativo a: ")
        SO = readln()

    }
    fun ProgramasInstalados(){

        val appsEsteAño = ProgramasInstalados.filter { it.endsWith("2026") }
        println("Aplicaciones")
        appsEsteAño.forEach { println("$it") }
        println("\n")
        }
    }