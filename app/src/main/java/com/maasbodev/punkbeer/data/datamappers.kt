package com.maasbodev.punkbeer.data

import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.data.server.entities.Beer as ServerBeer

fun ServerBeer.toDomainBeer(): Beer =
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
        volume = "${volume.value} ${volume.unit}",
        boil_volume = "${boil_volume.value} ${boil_volume.unit}",
        method = listOf(
            "${method.mash_temp[0].temp.value} ${method.mash_temp[0].temp.unit} (${method.mash_temp[0].duration} duration)",
            "${method.fermentation.temp.value} ${method.fermentation.temp.unit}",
            "${method.twist}"),
        ingredients = listOf(
            "${ingredients.malt[0].name}: ${ingredients.malt[0].amount.value} ${ingredients.malt[0].amount.unit}",
            "${ingredients.hops[0].name}: ${ingredients.hops[0].amount.value} ${ingredients.hops[0].amount.unit}. ${ingredients.hops[0].add}. ${ingredients.hops[0].attribute}",
            ingredients.yeast
        ),
        food_pairing = listOf(
            food_pairing.joinToString(separator = ", ")
        ),
        brewers_tips = brewers_tips,
        contributed_by = contributed_by
    )