package com.seif.shopping.onlineshopping.service.image;

import com.seif.shopping.onlineshopping.repository.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;


}
