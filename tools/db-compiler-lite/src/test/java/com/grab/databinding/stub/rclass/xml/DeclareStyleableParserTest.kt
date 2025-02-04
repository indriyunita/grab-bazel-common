/*
 * Copyright 2021 Grabtaxi Holdings PTE LTE (GRAB)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grab.databinding.stub.rclass.xml

import com.grab.databinding.stub.rclass.parser.Type
import com.grab.databinding.stub.rclass.parser.RFieldEntry
import org.junit.Test
import com.grab.databinding.stub.rclass.parser.XmlTypeValues

import kotlin.test.assertEquals
import com.grab.databinding.stub.rclass.parser.ResourceFileParser
import com.grab.databinding.stub.rclass.parser.ParserResult

import com.grab.databinding.stub.rclass.parser.xml.DeclareStyleableParser
import com.grab.databinding.stub.common.ParentXmlEntryImpl


class DeclareStyleableParserTest {

    private val styleableParser: ResourceFileParser = DeclareStyleableParser()

    private val value = "0"

    @Test
    fun `parse styleable`() {
        val children = listOf("colorAttr", "stringAttr", "sizeAttr")
        val parentValue = "{ 0,0,0 }"
        val result = styleableParser.parse(
            ParentXmlEntryImpl(
                "StyleableView",
                XmlTypeValues.DECLARE_STYLEABLE,
                children
            )
        )

        val exptectedValue = ParserResult(
            setOf(
                RFieldEntry(Type.STYLEABLE, "StyleableView", parentValue, isArray = true),
                RFieldEntry(Type.STYLEABLE, "StyleableView_colorAttr", value),
                RFieldEntry(Type.STYLEABLE, "StyleableView_stringAttr", value),
                RFieldEntry(Type.STYLEABLE, "StyleableView_sizeAttr", value)
            ), Type.STYLEABLE
        )

        assertEquals(result, exptectedValue)
    }
}