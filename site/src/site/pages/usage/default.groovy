article {
    a(name: 'default'){}
    h2 { yield 'Default Version' }
    p {
        pre { code '$ sdk default scala 2.11.6' }
        yield 'This will ensure that all subsequent shells will start with version 2.11.6 in use.'
        yield 'Choose to make a given version the default:'
    }
}
br()
