import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    ex01("data\\01.txt")
    ex01Part2("data\\01.txt")
    day02();
    day02Part2()
}

fun day02() {
    var depth = 0;
    var position = 0;

    val file = File("data\\02.txt");

    var lines = file.readLines();

    lines.forEach() {
        val params = it.split(' ')

        when (params[0]) {
            "forward" -> position += params[1].toInt()
            "down" -> depth += params[1].toInt()
            "up" -> depth -= params[1].toInt()
        }
    };

    println("Quest 02/1: ${position * depth}");
}

fun day02Part2() {
    var depth = 0;
    var position = 0;
    var aim = 0;

    val file = File("data\\02.txt");

    var lines = file.readLines();

    //lines = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")

    lines.forEach() {
        val params = it.split(' ')

        var units = params[1].toInt()

        when (params[0]) {
            "forward" -> {
                position += units
                depth += units * aim
            }
            "down" -> {
                //depth += units
                aim += units
            }
            "up" -> {
                //depth -= params[1].toInt()
                aim -= units
            }
        }
    }


    println("Quest 02/2: ${position * depth}");
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
