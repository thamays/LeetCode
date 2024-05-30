//1404. Number of Steps to Reduce a Number in Binary Representation to One
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/solutions/5228527/runtime-125-ms-beats-100-00-of-users-with-kotlin
fun main() {
//    println(numberOfStepsToReduceANumberInBinaryRepresentationToOne("1111110011101010110011100100101110010100101110111010111110110010"))
    println(numberOfStepsToReduceANumberInBinaryRepresentationToOne("1101"))
}

fun numberOfStepsToReduceANumberInBinaryRepresentationToOne(s: String): Int {
    var steps = 0
    var carry = 0

    for (i in s.length - 1 downTo 1) {
        if (s[i] - '0' + carry == 1) {
            carry = 1
            steps += 2
        } else {
            steps += 1
        }
    }

    return steps + carry
}
