import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    ex01("data\\01.txt")
}

fun ex01(fileName: String) {
    val file = File(fileName);

    var lines = file.readLines();

    var numbers = lines.map { it.toInt() };

    val count = numbers.zipWithNext().map { it.first < it.second }.count { a -> a };

    println("Quest 01: $count");
}
