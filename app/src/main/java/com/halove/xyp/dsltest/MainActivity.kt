package com.halove.xyp.dsltest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val person = fun1 {
            it.age = 12
            it.name = "xudaha"
        }

        fun2 {
            name = "xudaha"
            age = 12
        }


        fun3 {
            name = "xudaha"
            age = 12
            adress {
                adress = ""
            }
        }
    }

    /**
     * 如果一个函数的最后一个参数是lambda的话，那么可以把它提到外面，把括号去掉
     */
    fun fun1(block: (Person) -> Unit): Person{
        val person = Person()
        //block接收一個person参数，这里把它提供给外面进行赋值操作
        block(person)
        return person
    }


    /**
     * 为lambda提供一个接受者,在block中可以使用Person的一切
     */
    fun fun2(block: Person.() -> Unit): Person{
        val person = Person()
        person.block()
        return person
    }

    /**
     * 和fun2一样的效果
     */
    fun fun3(block: Person.() -> Unit): Person = Person().apply(block)


    fun Person.adress(block: Adress.() -> Unit){
        adress  = Adress().apply { block() }
    }
}
