/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2021-present Benoit 'BoD' Lubek (BoD@JRAF.org)
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

package org.jraf.klibnotion.internal.api.model.database

import kotlinx.serialization.Serializable
import org.jraf.klibnotion.internal.api.model.base.ApiEmojiOrFile
import org.jraf.klibnotion.internal.api.model.base.ApiReference
import org.jraf.klibnotion.internal.api.model.property.spec.ApiPropertySpec
import org.jraf.klibnotion.internal.api.model.richtext.ApiRichText

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiDatabase(
    val id: String,
    val parent: ApiReference,
    val title: List<ApiRichText>,
    val properties: Map<String, ApiPropertySpec>,
    val created_time: String,
    val last_edited_time: String,
    val icon: ApiEmojiOrFile?,
    // Technically this can only be "file" or "external", never "emoji"
    val cover: ApiEmojiOrFile?,
)
