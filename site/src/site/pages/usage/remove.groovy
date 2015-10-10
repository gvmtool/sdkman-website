article {
    a(name: 'remove'){}
    h2 { yield 'Remove Version' }
    p {
        yield 'Remove an installed version.'
        pre { code '$ sdk remove groovy 2.4.5' }
    }
}
br()
