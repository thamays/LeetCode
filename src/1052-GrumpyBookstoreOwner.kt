//1052. Grumpy Bookstore Owner
//https://leetcode.com/problems/grumpy-bookstore-owner
//
fun main() {
    println(maxSatisfied(intArrayOf(1, 0, 1, 2, 1, 1, 7, 5), intArrayOf(0, 1, 0, 1, 0, 1, 0, 1), 3))
    println(maxSatisfied(intArrayOf(1), intArrayOf(0), 1))
}

fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var happyCustomer = 0
    var extra = 0

    for (i in 0 until grumpy.size) {
        if (grumpy[i] == 0) happyCustomer += customers[i]

        if (i <= grumpy.size - minutes) {
            var temSum = 0
            for (j in i until i + minutes) {
                if (grumpy[j] == 1)
                    temSum += customers[j]
            }

            if (extra < temSum)
                extra = temSum
        }
    }

    return happyCustomer + extra
}