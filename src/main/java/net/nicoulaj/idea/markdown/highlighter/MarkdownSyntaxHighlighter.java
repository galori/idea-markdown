/*
 * Copyright (c) 2011 Julien Nicoulaud <julien.nicoulaud@gmail.com>
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package net.nicoulaj.idea.markdown.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import net.nicoulaj.idea.markdown.lang.MarkdownTokenTypeSets;
import net.nicoulaj.idea.markdown.lang.lexer.MarkdownLexer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link com.intellij.openapi.fileTypes.SyntaxHighlighter} implementation for the Markdown language.
 *
 * @author Julien Nicoulaud <julien.nicoulaud@gmail.com>
 * @since 0.1
 */
public class MarkdownSyntaxHighlighter extends SyntaxHighlighterBase {

    /**
     * TODO Add Javadoc comment.
     */
    protected final MarkdownLexer markdownLexer = new MarkdownLexer();

    /**
     * TODO Add Javadoc comment.
     */
    protected static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

    static {
        fillMap(ATTRIBUTES, MarkdownTokenTypeSets.PLAIN_TEXT_SET, MarkdownHighlighterColors.PLAIN_TEXT_ATTR_KEY);
        fillMap(ATTRIBUTES, MarkdownTokenTypeSets.BOLD_TEXT_SET, MarkdownHighlighterColors.BOLD_TEXT_ATTR_KEY);
        fillMap(ATTRIBUTES, MarkdownTokenTypeSets.ITALIC_TEXT_SET, MarkdownHighlighterColors.ITALIC_TEXT_ATTR_KEY);
        fillMap(ATTRIBUTES, MarkdownTokenTypeSets.LINK_SET, MarkdownHighlighterColors.LINK_ATTR_KEY);
        fillMap(ATTRIBUTES, MarkdownTokenTypeSets.BAD_CHARACTER_SET, MarkdownHighlighterColors.BAD_CHARACTER_ATTR_KEY);
    }

    /**
     * Get the lexer used for highlighting a Markdown file.
     *
     * @return a {@link MarkdownLexer}.
     */
    @NotNull
    public Lexer getHighlightingLexer() {
        return markdownLexer;
    }

    /**
     * TODO Add Javadoc comment.
     *
     * @param tokenType TODO Add Javadoc comment.
     * @return TODO Add Javadoc comment.
     */
    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }
}