/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  nice-markdown
 * File     element.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 *
 */

@file:Suppress("unused")

package love.forte.nmd.element

import love.forte.nmd.element.MarkdownElement as ME

/**
 * the elements for markdown
 * like:
 * - h1~h5
 * - table
 * - comment
 * - code
 * - text
 *
 */
interface MarkdownElement: CharSequence, java.io.Serializable {

    /** to markdown text string */
    fun toMarkdown(): String

    /**
     * Returns the length of this character sequence.
     */
    override val length: Int
        get() = toString().length

    /**
     * Returns the character at the specified [index] in this character sequence.
     */
    override operator fun get(index: Int): Char = toString()[index]

    /**
     * Returns a new character sequence that is a subsequence of this character sequence,
     * starting at the specified [startIndex] and ending right before the specified [endIndex].
     */
    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence = toString().subSequence(startIndex, endIndex)
}



