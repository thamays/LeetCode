//2037. Minimum Number of Moves to Seat Everyone
//https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone
//
fun main() {
    println(minMovesToSeat(intArrayOf(3, 1, 5), intArrayOf(2, 7, 4)))
    println(minMovesToSeat(intArrayOf(4, 1, 5, 9), intArrayOf(1, 3, 2, 6)))
    println(minMovesToSeat(intArrayOf(2, 2, 6, 6), intArrayOf(1, 3, 2, 6)))
}

fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    var move = 0

    seats.sort()
    students.sort()

    for (n in students.indices) {
        if (students[n] != seats[n]) {
            val diff = students[n] - seats[n]
            move += if (diff < 0) {
                -diff
            } else {
                diff
            }
        }
    }

    return move
}