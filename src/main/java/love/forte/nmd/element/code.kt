/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  nice-markdown
 * File     code.kt
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


/**
 * md code
 * ```[type]
 * `代码内容`
 *
 * \```
 *  代码...
 *  代码...
 *  代码...
 *  \```
 *
 * ```
 */
interface MarkdownCode: MarkdownElement
