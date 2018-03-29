@file:Suppress("UNCHECKED_CAST")

package fr.ekito.myweatherapp.util.ext

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import java.io.Serializable

/**
 * Start an Activity for given class T and allow to work on intent with "run" lambda function
 */
fun Fragment.withArguments(vararg arguments: Pair<String, Serializable>): Fragment {
    val bundle = Bundle()
    arguments.forEach { bundle.putSerializable(it.first, it.second) }
    this.arguments = bundle
    return this
}

/**
 * Retrieve argument from Activity intent
 */
fun <T : Any> FragmentActivity.argument(key: String) =
    lazy { intent.extras[key] as? T ?: error("Intent Argument $key is missing") }

/**
 * Retrieve argument from Fragment arguments
 */
fun <T : Any> Fragment.argument(key: String) =
    lazy { arguments?.get(key) as? T ?: error("Fragment Argument $key is missing") }
