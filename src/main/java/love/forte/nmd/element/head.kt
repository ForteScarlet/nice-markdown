/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  nice-markdown
 * File     head.kt
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
 * markdown element: head
 * like
 * ```
 * # h1
 * ## h2
 * ### h3
 * ...
 * ```
 */
interface MarkdownHead: MarkdownElement {
    /**
     * get head level
     * h1 -> 1
     * h2 -> 2
     */
    var level: Int

    /**
     * title
     * 此标题的内容
     */
    var title: MarkdownElement

    /**
     * head content
     * content list
     * 此标题下包含的内容，一直延续要同等级或高等级的head
     */
    val content: MutableList<MarkdownElement>
}
