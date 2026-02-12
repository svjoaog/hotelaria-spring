import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { SetorPage } from './pages/Setores/SetorPage'
import { SalaPage } from './pages/Sala/SalaPage'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <SalaPage />
  </StrictMode>,
)
