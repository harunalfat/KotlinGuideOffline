package org.lafzi.kotlinguideoffline.constants

import org.lafzi.kotlinguideoffline.R

/**
 * Created by alfat on 27/05/17.
 */

object MenuItemToTitle {

    val map = mutableMapOf<Int, String>()

    init {
        map[R.id.basic_syntax] = "basic-syntax.md"
        map[R.id.idioms] = "idioms.md"
        map[R.id.coding_conventions] = "coding-conventions.md"

        map[R.id.basic_types] = "basic-types.md"
        map[R.id.packages] = "packages.md"
        map[R.id.control_flow] = "control-flow.md"
        map[R.id.returns_and_jumps] = "returns.md"

        map[R.id.classes_and_inheritance] = "classes.md"
        map[R.id.properties_and_fields] = "properties.md"
        map[R.id.interfaces] = "interfaces.md"
        map[R.id.visibility_modifiers] = "visibility-modifiers.md"
        map[R.id.extensions] = "extensions.md"
        map[R.id.data_classes] = "data-classes.md"
        map[R.id.sealed_classes] = "sealed-classes.md"
        map[R.id.generics] = "generics.md"
        map[R.id.nested_classes] = "nested-classes.md"
        map[R.id.enum_classes] = "enum-classes.md"
        map[R.id.objects] = "objects.md"
        map[R.id.delegation] = "delegation.md"
        map[R.id.delegated_properties] = "delegated-properties.md"

        map[R.id.functions] = "functions.md"
        map[R.id.lambdas] = "lambdas.md"
        map[R.id.inline_functions] = "inline-functions.md"
        map[R.id.coroutines] = "coroutines.md"

        map[R.id.destructuring_declarations] = "multi-declarations.md"
        map[R.id.collections] = "collections.md"
        map[R.id.ranges] = "ranges.md"
        map[R.id.type_checks_and_casts] = "typecasts.md"
        map[R.id.this_expressions] = "this-expressions.md"
        map[R.id.equality] = "equality.md"
        map[R.id.operator_overloading] = "operator-overloading.md"
        map[R.id.null_safety] = "null-sa fety.md"
        map[R.id.exceptions] = "exceptions.md"
        map[R.id.annotations] = "annotations.md"
        map[R.id.reflection] = "reflections.md"
        map[R.id.type_safe_builders] = "type-safe-builders.md"
        map[R.id.type_aliases] = "type-aliases.md"
    }
}