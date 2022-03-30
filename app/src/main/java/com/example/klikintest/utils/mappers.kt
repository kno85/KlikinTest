package com.example.klikintest.utils

import com.example.klikintest.domain.*
import com.example.klikintest.network.model.Address
import com.example.klikintest.network.model.Config


fun toDomainCommerces(items: List<com.example.klikintest.network.model.Commerces>?): List<Commerces>? {
        if (items != null) {
            return(items.map {
                Commerces(
                    id= it.id,
                    name = it.name,
                    description = it.description,
                    address =  mapAddress(it.address),
                    config =  mapConfig(it.config),
                    contact = mapContact(it.contact),
                    logo = mapLogo(it.logo),
                    photos = mapPhotos(it.photos),
                    social = mapSocial(it.social)
                )
            })
        }
        else
            return emptyList()
    }

private fun mapSocial(social: com.example.klikintest.network.model.Social?): Social {
    return com.example.klikintest.domain.Social(
        social?.facebook
    )}

private fun mapPhotos(photos: ArrayList<com.example.klikintest.network.model.Photos>?): ArrayList<Photos> {
    val photosList= ArrayList<Photos>()
    photos?.map {
        Photos(
            it._id,
            it.format,
            it.url,
            mapThumbnail(it.thumbnails)
        )}?.let { photosList.addAll(it) }
    return photosList
}

private fun mapLogo(logo: com.example.klikintest.network.model.Logo?): Logo{
    return com.example.klikintest.domain.Logo(
        logo?.url,
        logo?.format,
        mapThumbnail(logo?.thumbnails)
    )}

private fun mapThumbnail(thumbnails: com.example.klikintest.network.model.Thumbnails?): Thumbnails {
    return com.example.klikintest.domain.Thumbnails(
        thumbnails?.small,
        thumbnails?.medium,
        thumbnails?.large
    )}
private fun mapContact(contact: com.example.klikintest.network.model.Contact?): Contact {
    return com.example.klikintest.domain.Contact(
        contact?.phone,
        contact?.email,
        contact?.web
    )}

private fun mapConfig(config: Config?): com.example.klikintest.domain.Config {
    return com.example.klikintest.domain.Config(
        config?.timezone,
        config?.currency,
        config?.locale,
    )}

private fun mapAddress(address: Address?): com.example.klikintest.domain.Address {
    return com.example.klikintest.domain.Address(
        address?.zip,
        address?.city,
        address?.country,
        address?.street
    )
}

