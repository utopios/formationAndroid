const express = require('express')
const app = express()
const fakeData = [
    {
        'id' : 1,
        'title' : 'test 1',
        'priority' : 1
    },
    {
            'id' : 2,
            'title' : 'test 2',
            'priority' : 2
        },
]

app.get('/todos', (req, res) => {
res.json(fakeData)
})

app.listen(3000, () => {
})