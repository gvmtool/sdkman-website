article {
    a(name: 'remove'){}
    h2 { yield 'Remove Version' }
    p {
        yield 'Remove an installed version.'
        pre { code '$ sdk rm scala 2.11.6' }
    }
}
br()
