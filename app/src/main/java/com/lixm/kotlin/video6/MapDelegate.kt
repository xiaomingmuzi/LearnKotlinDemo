package com.lixm.kotlin.video6

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/27
 */
class MapDelegate(var map: MutableMap<String, String>) : ReadWriteProperty<Any, String> { //Any 是指receiver

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return map[property.name] ?: ""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        map[property.name] = value
    }
}