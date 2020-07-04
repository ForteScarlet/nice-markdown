/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  nice-markdown
 * File     SimpleHtml.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 *
 */

package love.forte.nmd.utils

import love.forte.nmd.element.HtmlAble
import java.util.*

/**
 * for html
 * @param tag html tag
 * @param attributes attributes
 */
open class SimpleHtml
@JvmOverloads
constructor(var tag: String, private val attributes: MutableMap<String, Any?> = mutableMapOf()): HtmlAble {

    /**
     *  content
     *  `inPair` must be `true`
     * */
    var content: Any? = null

    /**
     * to html string
     */
    override fun toHtml(attributes: Map<String, Any?>?, inPairs: Boolean): String {
        // <title  k="v"  />
        val joiner = if(inPairs){
            StringJoiner(" ", "", ">${content?.toString() ?: ""}</$tag>")
        }else{
            StringJoiner(" ", "", " />")
        }.add("<$tag")

        this.attributes.forEach {
            val value = it.value
            if(value != null){
                joiner.add("${it.key}=\"$value\"")
            }
        }
        attributes?.forEach {
            val value = it.value
            if(value != null){
                joiner.add("${it.key}=\"$value\"")
            }
        }
        return joiner.toString()
    }

    operator fun get(key: String) = attributes[key]
    operator fun set(key: String, value: Any?) {
        attributes[key] = value
    }

    override fun toString(): String = toHtml()
}


/**
 * DSL builder for [SimpleHtml]
 */
class SimpleHtmlBuilder(htmlTag: String) {
    /** [SimpleHtml] */
    internal val simpleHtml = SimpleHtml(htmlTag)
    /** html tag */
    var tag: String
    get() = simpleHtml.tag
    set(value) {
        simpleHtml.tag = value
    }

    /** is inPairs */
    var inPairs: Boolean = true

    /**
     * for DSL like: **`set attr "key" value "value"`**
     */
    val set = this

    var content: Any?
    get() = simpleHtml.content
    set(value) {
        simpleHtml.content = value
    }

    //**************** get & set ****************//

    /**
     * set value
     */
    operator fun set(key: String, value: Any?) {
        simpleHtml[key] = value
    }

    /**
     * get value
     */
    operator fun get(key: String) = simpleHtml[key]

    /**
     * get value and to string or null
     */
    fun getString(key: String) = simpleHtml[key]?.toString()


    //**************** toString & toHtml ****************//


    fun toHtml(inPairs: Boolean = this.inPairs): String = simpleHtml.toHtml(inPairs = inPairs)
    override fun toString(): String = toHtml()

}

//****************//
//
// for DSL: set attr "key" value "value"
//
//****************//


data class HtmlAttrKey(val key: String, val html: SimpleHtml)
infix fun SimpleHtmlBuilder.attr(key: String): HtmlAttrKey = HtmlAttrKey(key, this.simpleHtml)
infix fun SimpleHtmlBuilder.attr(pairs: () -> Pair<String, Any?>) {
    val p = pairs()
    this[p.first] = p.second
}
infix fun HtmlAttrKey.value(value: Any?) {
    this.html[this.key] = value
}
infix fun HtmlAttrKey.value(value:() -> Any?) {
    this.html[this.key] = value()
}

//****************//
//
// for DSL: set content value
//
//****************//

infix fun SimpleHtmlBuilder.content(content: Any?) {
    this.content = content
}




// simple html DSL

fun html(tag: String, build: SimpleHtmlBuilder.() -> Unit): SimpleHtmlBuilder {
    val builder = SimpleHtmlBuilder(tag)
    build(builder)
    return builder
}


//**************** template for html DSL ****************//



fun SimpleHtmlBuilder.h(level: Int, text: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder {
    val h = html("h$level") { set content text }
    build(h)
    this content h
    return h
}
fun SimpleHtmlBuilder.h1(text: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder = this.h(1, text)
fun SimpleHtmlBuilder.h2(text: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder = this.h(2, text)
fun SimpleHtmlBuilder.h3(text: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder = this.h(3, text)
fun SimpleHtmlBuilder.h4(text: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder = this.h(4, text)
fun SimpleHtmlBuilder.h5(text: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder = this.h(5, text)
fun SimpleHtmlBuilder.p(text: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder {
    val p = html("p") { set content text }
    build(p)
    this content p
    return p
}
fun SimpleHtmlBuilder.a(href: String, build: SimpleHtmlBuilder.() -> Unit = {}): SimpleHtmlBuilder {
    val a = html("a") {
        set attr "href" to href
    }
    build(a)
    set content a
    return a
}
