/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  nice-markdown
 * File     ables.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 *
 */

package love.forte.nmd.element

/**
 * bold able
 * 可加粗的
 * [T] 标记方法的返回值。有时候返回值可能是自己，有时候返回值可能不是
 */
interface BoldAble<T: MarkdownElement> {
    fun bold(): T
    @JvmDefault fun b() = bold()
}

/**
 * tilt able
 * 可倾斜的
 * [T] 标记方法的返回值。有时候返回值可能是自己，有时候返回值可能不是
 */
interface TiltAble<T: MarkdownElement> {
    fun tilt(): T
    @JvmDefault fun i() = tilt()
}

/**
 * can be bold and tilt
 */
interface TiltAndBoldAble<T: MarkdownElement>: BoldAble<T>, TiltAble<T> {
    @JvmDefault fun boldAndTilt(): T
}


/**
 * Strikethrough able
 * 删除线
 */
interface StrikethroughAble<T: MarkdownElement> {
    fun strikethrough(): T
    @JvmDefault fun s(): T = strikethrough()
}

/**
 * has urlAble
 */
interface UrlAble {
    var url: String
}

/**
 * can be html
 * 可转化为html
 */
interface HtmlAble {
    /**
     * to html string, and add some other attributes
     * @param attributes some other attributes for html. null able
     */
    fun toHtml(attributes: Map<String, Any?>? = emptyMap(), inPairs: Boolean = true): String
    @JvmDefault fun toHtml(): String = toHtml(emptyMap())
}


