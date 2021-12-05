package com.maasbodev.punkbeer.data

import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.data.database.Beer as RoomBeer
import com.maasbodev.punkbeer.data.server.entities.Beer as ServerBeer

fun Beer.toRoomBeer(): RoomBeer =
    RoomBeer(
        id = id,
        name = name,
        tagline = tagline,
        first_brewed = first_brewed,
        description = description,
        image_url = image_url,
        abv = abv,
        ibu = ibu,
        target_fg = target_fg,
        target_og = target_og,
        ebc = ebc,
        srm = srm,
        ph = ph,
        attenuation_level = attenuation_level,
        volume = volume,
        boil_volume = boil_volume,
        method = method.joinToString(separator = System.lineSeparator()),
        ingredients = ingredients.joinToString(separator = System.lineSeparator()),
        food_pairing = food_pairing.joinToString(separator = System.lineSeparator()),
        brewers_tips = brewers_tips,
        contributed_by = contributed_by
    )

fun RoomBeer.toDomainBeer(): Beer =
    Beer(
        id = id,
        name = name,
        tagline = tagline,
        first_brewed = first_brewed,
        description = description,
        image_url = image_url,
        abv = abv,
        ibu = ibu,
        target_fg = target_fg,
        target_og = target_og,
        ebc = ebc,
        srm = srm,
        ph = ph,
        attenuation_level = attenuation_level,
        volume = volume,
        boil_volume = boil_volume,
        method = listOf(method),
        ingredients = listOf(ingredients),
        food_pairing = listOf(food_pairing),
        brewers_tips = brewers_tips,
        contributed_by = contributed_by
    )

fun ServerBeer.toDomainBeer(): Beer {
    val beerMethod = mutableListOf<String>()
    val beerIngredients = mutableListOf<String>()

    for (index in method.mash_temp.indices) {
        beerMethod.add(
            "Mesh temp: ${method.mash_temp[index].temp.value} " +
                    "${method.mash_temp[index].temp.unit} " +
                    "(duration ${method.mash_temp[index].duration})"
        )
    }

    beerMethod.add(
        "Fermentation temp: ${method.fermentation.temp.value} " +
                method.fermentation.temp.unit
    )
    beerMethod.add("Twist: ${method.twist}")

    for (index in ingredients.malt.indices) {
        beerIngredients.add(
            "Ingredient: ${ingredients.malt[index].name}: " +
                    "${ingredients.malt[index].amount.value} ${ingredients.malt[index].amount.unit}"
        )
    }

    for (index in ingredients.hops.indices) {
        beerIngredients.add(
            "Hop: ${ingredients.hops[index].name}: " +
                    "${ingredients.hops[index].amount.value} ${ingredients.hops[index].amount.unit}. " +
                    "${ingredients.hops[index].add}. ${ingredients.hops[index].attribute}"
        )
    }

    beerIngredients.add(ingredients.yeast)
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        first_brewed = first_brewed,
        description = description,
        image_url = image_url,
        abv = abv,
        ibu = ibu,
        target_fg = target_fg,
        target_og = target_og,
        ebc = ebc,
        srm = srm,
        ph = ph,
        attenuation_level = attenuation_level,
        volume = "${volume.value} ${volume.unit}",
        boil_volume = "${boil_volume.value} ${boil_volume.unit}",
        method = beerMethod,
        ingredients = beerIngredients,
        food_pairing = listOf(food_pairing.joinToString(separator = ", ")),
        brewers_tips = brewers_tips,
        contributed_by = contributed_by
    )
}