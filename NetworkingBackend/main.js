const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  let dataPath = require('./data.json')
  res.send(JSON.stringify(dataPath))
})

app.listen(port, () => {
  console.log(`Listening at http://localhost:${port}`)
})