/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  nice-markdown
 * File     table.kt
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
 * md table
 * ```
 * 表头|表头|表头
 * ---|:--:|---:
 * 内容|内容|内容
 * 内容|内容|内容
 *
 *
 *  第二行分割表头和内容。
 *  - 有一个就行，为了对齐，多加了几个
 *  文字默认居左
 *  -两边加：表示文字居中
 *  -右边加：表示文字居右
 *  注：原生的语法两边都要用 | 包起来。此处省略
 *
 * ```
 */
interface MarkdownTable: MarkdownElement, HtmlAble