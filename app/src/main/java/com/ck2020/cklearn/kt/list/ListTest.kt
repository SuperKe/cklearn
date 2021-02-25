package com.ck2020.cklearn.kt.list

/**
 * @author chenke
 * @create 2021/2/1
 * @Describe
 * 集合相关操作
 */
class ListTest {
    companion object {
        var testList = listOf(0, 1, 2, 3, 4, 5, 6, 7)

        @JvmStatic
        fun main(args: Array<String>) {
            testList.forEach {
                print("集合元素：${it}\n")
            }
            //filter，集合过滤
            testList.filter {
                it > 3
            }.forEach {
                print("filter:集合元素：${it}\n")
            }
            //map，集合变换
            testList.map {
                it + 1
            }.forEach {
                print("map:集合元素：${it}\n")
            }
            //flatMap:集合变换，表达式中产生新的集合，最后合并成一个集合
            testList.flatMap {
                listOf(it + 2, it * 1)
            }.forEach {
                print("flatMap:集合元素：${it}\n")
            }
            //惰性集合,特点：惰性函数是不会在调用之前不会执行，且在函数变换完成之后，将不再继续执行，类似于java的break/return
            val sequence = sequenceOf(1, 2, 3, 4)
            val result = sequence
                .map { i ->
                    println("Map $i\n")
                    i * 2
                }.filter { i ->
                    println("Filter $i\n")
                    i % 3 == 0
                    //如果能被3整除，则不会继续进行遍历
                }
            print("惰性集合遍历:${result.first()}\n")
            //非惰性要遍历到集合完成
            testList.map {
                println("Map $it\n")
                it * 2
            }.filter {
                println("Filter $it\n")
                it % 3 == 0
                //执行到遍历结束
            }
            print("非惰性遍历:${result.first()}\n")
        }
    }
}