import baseAxios from 'axios';
import { getToken } from './JWT-common';

const axios = baseAxios.create({
  baseURL: 'http://localhost:8081/api/v1/auth',
  headers: {
    'Content-Type': 'application/json',
  },
});

export default axios;