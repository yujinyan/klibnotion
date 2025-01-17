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

import org.jraf.klibnotion.internal.api.model.ApiConverter
import org.jraf.klibnotion.internal.api.model.apiToModel
import org.jraf.klibnotion.internal.api.model.base.ApiEmojiOrFileConverter
import org.jraf.klibnotion.internal.api.model.base.ApiReferenceConverter
import org.jraf.klibnotion.internal.api.model.date.ApiDateStringConverter
import org.jraf.klibnotion.internal.api.model.property.spec.ApiPropertySpecConverter
import org.jraf.klibnotion.internal.api.model.richtext.ApiRichTextConverter
import org.jraf.klibnotion.internal.model.database.DatabaseImpl
import org.jraf.klibnotion.model.database.Database
import org.jraf.klibnotion.model.file.File
import org.jraf.klibnotion.model.richtext.RichTextList

internal object ApiDatabaseConverter : ApiConverter<ApiDatabase, Database>() {
    override fun apiToModel(apiModel: ApiDatabase): DatabaseImpl = DatabaseImpl(
        id = apiModel.id,
        parent = apiModel.parent.apiToModel(ApiReferenceConverter),
        title = RichTextList(ApiRichTextConverter.apiToModel(apiModel.title)),
        propertySpecs = ApiPropertySpecConverter.apiToModel(
            apiModel.properties.map { it.key to it.value }
        ),
        created = apiModel.created_time.apiToModel(ApiDateStringConverter).timestamp,
        lastEdited = apiModel.last_edited_time.apiToModel(ApiDateStringConverter).timestamp,
        icon = apiModel.icon.apiToModel(ApiEmojiOrFileConverter),
        cover = apiModel.cover.apiToModel(ApiEmojiOrFileConverter) as? File,
    )
}