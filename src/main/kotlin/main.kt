fun main() {
    val seconds = 60 * 60 * 2
    println(agoToText(seconds))

}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0 until 60 -> "был(а) в сети только что"
        in 60 until 60 * 60 -> "был(а) в сети ${minutesAgo(seconds)}"
        in 60 * 60 until 24 * 60 * 60 -> "был(а) в сети ${hoursAgo(seconds)}"
        in 24 * 60 * 60 until 48 * 60 * 60 -> "был(а) в сети вчера"
        in 48 * 60 * 60 until 72 * 60 * 60 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

fun minutesAgo(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        (minutes == 1) || (minutes % 10 == 1) && (minutes != 11) -> "$minutes минуту назад"
        ((minutes % 10 == 2) || (minutes % 10 == 3) || (minutes % 10 == 4)) && (minutes !in 12..14) || (minutes in  2..4) -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursAgo(seconds: Int): String {
    val hours = seconds / 60 / 60
    return when {
        (hours == 1) || (hours % 10 == 1) && (hours != 11) -> "$hours час назад"
        (hours in 2..4) || (hours in 22 until 24) -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}