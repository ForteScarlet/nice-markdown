/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  nice-markdown
 * File     list.kt
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
 * mark list
 * ```
 * Ordered:
 *
 * 1. 列表内容
 * 2. 列表内容
 * 3. 列表内容
 *
 * 注意：序号跟内容之间要有空格
 *
 * Disordered:
 *
 * - 列表内容
 * + 列表内容
 * * 列表内容
 *
 * 注意：- + * 跟内容之间都要有一个空格
 *
 * 列表嵌套
 * 上一级和下一级之间敲三个空格即可
 *
 * ```
 */
interface MarkdownList: MarkdownElement, HtmlAble
