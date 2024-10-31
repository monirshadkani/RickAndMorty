package fr.epsi.shadkani.rickandmorty

import android.annotation.SuppressLint
import android.content.Context

object DataHelper {
    @SuppressLint("DiscouragedApi")
    fun listCharModel(context: Context): ArrayList<CharModel> {
        val charModels = ArrayList<CharModel>()
        var i = 1

        while (true) {

            val resId_name = context.resources.getIdentifier("name$i", "string", context.packageName)
            if (resId_name == 0) break
            val resId_status = context.resources.getIdentifier("status$i", "string", context.packageName)
            val resId_species = context.resources.getIdentifier("species$i", "string", context.packageName)
            val resId_origin = context.resources.getIdentifier("origin$i", "string", context.packageName)
            val resId_image = context.resources.getIdentifier("image$i", "string", context.packageName)



            val name = context.getString(resId_name)
            val status = context.getString(resId_status)
            val species = context.getString(resId_species)
            val origin = context.getString(resId_origin)
            val image = context.getString(resId_image)

            val charModel = CharModel(
                char_name = name,
                char_status = status,
                char_species = species,
                char_origin = origin,
                char_image = image
            )
            charModels.add(charModel)

            i++
        }

        return charModels
    }
}

