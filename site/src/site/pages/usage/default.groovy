article {
    a(name: 'default'){}
    h2 { yield 'Default Version' }
    p {
        yield 'Choose to make a given version the default:'
        pre { code '$ sdk default groovy 2.3.9' }
        yield 'This will ensure that all subsequent shells will start with version 2.3.9 in use.'
    }
}
br()
