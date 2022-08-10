import baseAxios from 'axios';

const axios = baseAxios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
  },
});

export default axios;