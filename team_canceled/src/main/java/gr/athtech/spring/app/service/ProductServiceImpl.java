package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.ProductCategory;
import gr.athtech.spring.app.model.Product;
import gr.athtech.spring.app.repository.BaseRepository;
import gr.athtech.spring.app.repository.ProductCategoryRepository;
import gr.athtech.spring.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryService productCategoryService;

    @Override
    protected BaseRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public Product findByName(final String Name) {
        return productRepository.findByName(Name);
    }

    /////////////////////////////////////////////////////////////////////
//    @Override
//    public Product create(final Product product, final Long productCategoryId) {
//        var productCategory = productCategoryService.get(productCategoryId);
//        product.setCategories(productCategory);
//        return productRepository.create(product);
//    }
    ///////////////////////////////////////////////////////////////////
}
