package com.Valeria.computadora

class Estudiante(var nombre: String, var carnet: String, var asignatura: String){
    fun DatosEstudiante(){
    println("Nombre del Estudiante: $nombre\n" +
            "Carnet: $carnet")
    }
}

val Ciclo01 = listOf(Estudiante("Jerry","12345","Analisis numerico"),
                    Estudiante("Luna","54321","Analisis numerico"),
                    Estudiante("Leo","13579","Analisis numerico"),
                    Estudiante("Emely","97531","Analisis numerico"),
                    Estudiante("Mema","24680","Programacion de Dispositivos Moviles"),
                    Estudiante("Lola","08642","Programacion de Dispositivos Moviles"),
                    Estudiante("Solecito","14699","Programacion de Dispositivos Moviles"))

fun EstudiantesAsignatura(){
    val Estudiantes = Ciclo01.filter { it.asignatura == "Programacion de Dispositivos Moviles" }
    println("Estudiantes de Programacion de Dispositivos Moviles")
    Estudiantes.forEach { it -> it.DatosEstudiante() }
    println("\n")
}


fun main(){
EstudiantesAsignatura()

}