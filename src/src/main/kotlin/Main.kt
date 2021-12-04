import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    ex01("data\\01.txt")
    ex01Part2("data\\01.txt")
}

fun ex01(fileName: String) {
    val file = File(fileName);

    var lines = file.readLines();

    var numbers = lines.map { it.toInt() };

    val count = numbers.zipWithNext().map { it.first < it.second }.count { a -> a };

    println("Quest 01: $count");
}

fun ex01Part2(fileName: String) {
    val file = File(fileName);

    var lines = file.readLines();

    var numbers = lines.map { it.toInt() };

    var old = numbers[0] + numbers[1] + numbers[2];

    var count = 0;

    for (value in 0..numbers.count() - 3 ) {

        var new = numbers[value] + numbers[value + 1] + numbers[value + 2];

        if (new > old) count ++;

        old = new
    }

    println("Quest 01: $count");
}
